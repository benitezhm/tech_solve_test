const React = require('react');
const ReactDOM = require('react-dom');
import { connect } from "redux";
import axios from 'axios';
import store from "./store";
import { setInputData, setOutputData, setIdentification } from "./actions";

window.store = store;
// window.setInputData = setInputData;

class App extends React.Component {
	
	constructor(props) {
		super(props);
		this.state = {messageFile: "", messageId: ""};
		this.handleSubmit =  this.handleSubmit.bind(this);
	}
	
	handleSubmit(event) {
		event.preventDefault();
		this.setState({messageId: "", messageFile: ""});
		// validate if the identification number is present
		if (store.getState().identification == "") {
			this.setState({messageId: "No identification number"});
			return;
		}
		let lines = store.getState().inputData.split("\n");
		// validate if the lines from the input file is present
		if (lines[0] == "" || lines == "") {
			this.setState({messageFile: "No input file or file is empty"});
			return;
		}
		let numberOfDays = parseInt(lines[0]);
		let numberOfElements = 0;
		let data = [];
		let index = 0;
		for (let j = 1; j <= numberOfDays; j++) { // iterate over the days
			let caseNo = "case #" + j;
			index = index + 1;
			numberOfElements = parseInt(lines[index]);
			let elements = [];
			for (let i = 1; i <= numberOfElements; i++) {
				index = index + 1;
				elements.push(parseInt(lines[index]));
			}
			data.push({caseName: caseNo, elements: elements, 
				identification: store.getState().identification}); 
		}
		
		// backend call here
		axios.post(`http://localhost:8080/process_input`, data)
			.then(res => {
				store.dispatch(setOutputData(res.data));
		});
		window.location = "#";
	}
	
	render() {
		return (
			<React.Fragment>
				<div className="title">
					<div className="title-text">
						<h1>Tech and Solve Test</h1>
						<h2>Lazy Loading</h2>
					</div>
					<div className="title-img"><img src="/images/logo-tech-and-solve.png" /></div>
				</div>
				<table>
					<thead>
						<tr>
							<td><strong>Input:</strong></td>
							<td><strong>Output:</strong></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>
								{this.state.messageId != "" &&
									<div className="warning">{this.state.messageId}</div>
								}
								<InputIdentification />
								{this.state.messageFile != "" &&
									<div className="warning">{this.state.messageFile}</div>
								}
								<InputFileReader />
							</td>
							<td> <OutputData /> </td>
						</tr>
						<tr>
							<td colSpan="2">
								<button className="submit" onClick={this.handleSubmit}>Submit</button>
							</td>
						</tr>
					</tbody>
				</table>
			</React.Fragment>
		)
	}
}

class InputData extends React.Component {
	constructor(props) {
		super(props);
		this.handleChange = this.handleChange.bind(this);
	}
	
	handleChange(event) {
		store.dispatch(setInputData(event.target.value));
	}
	
	render() {
		return (
			<React.Fragment>
				<label htmlFor="input">Input:</label>
				<textarea rows="20" cols="50" onChange={this.handleChange} 
					value={store.getState.inputData} />
			</React.Fragment>
		)
	}
}

class InputIdentification extends React.Component {
	constructor(props) {
		super(props);
		this.handleChange = this.handleChange.bind(this);
	}
	
	handleChange(event) {
		store.dispatch(setIdentification(event.target.value));
	}
	
	render() {
		return (
			<React.Fragment>
				<label htmlFor="input">Identification:</label>
				<input type="number" onChange={this.handleChange} 
					value={store.getState.identification} />
			</React.Fragment>
		)
	}
}

class InputFileReader extends React.Component {
	
	constructor(props) {
		super(props);
		this.state = {fileName: ""};
		this.handleFileChoosen = this.handleFileChoosen.bind(this);
	}
	
	handleFileChoosen(event) {
		let file = event.target.files[0]
		this.setState({fileName: file.name});
		let fileReader = new FileReader();
		fileReader.onloadend = () => {
		      store.dispatch(setInputData(fileReader.result));
	    }
		fileReader.readAsText(file);
	}
	
	render() {
		return (
			<React.Fragment>
				<div className="input-file-container">
					<input type='file' id='file' className='input-file'
						accept='.txt' onChange={this.handleFileChoosen} />
					<label tabIndex="0" htmlFor="file" className="input-file-trigger">Select a file...</label>
					<p>{this.state.fileName}</p>
				</div>
			</React.Fragment>
		)
	}
	
}

class OutputData extends React.Component {
	
	constructor(props) {
		super(props);
		this.state = {elements: []};
		this.updateStateFromStore = this.updateStateFromStore.bind(this);
	}
	
	componentDidMount() {
		this.unsubscribeStore = store.subscribe(this.updateStateFromStore);
	}
	
	updateStateFromStore(event) {
		this.setState({elements: store.getState().outputData});
	}
	
	render() {
		let output = this.state.elements.map(function(el) {
			return <li key={el}>{el}</li>
		});
		return (
			<React.Fragment>
				<div className="output">
					<ul>{output}</ul>
				</div>
			</React.Fragment>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)