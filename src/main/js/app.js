const React = require('react');
const ReactDOM = require('react-dom');
import { connect } from "redux";
import axios from 'axios';
import store from "./store";
import { setInputData, setOutputData } from "./actions";

window.store = store;
// window.setInputData = setInputData;

class App extends React.Component {
	
	constructor(props) {
		super(props);
		this.handleSubmit =  this.handleSubmit.bind(this);
	}
	
	handleSubmit(event) {
		event.preventDefault();
		let lines = store.getState().inputData.split("\n");
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
			data.push({caseName: caseNo, elements: elements}); 
		}
		
		// backend call here
		axios.post(`http://localhost:8080/process_input`, data)
			.then(res => {
				console.log(res);
				store.dispatch(setOutputData(res.data));
		});
		window.location = "#";
	}
	
	render() {
		return (
			<table>
				<tbody>
					<tr>
						<td> <InputIdentification /><InputFileReader /> </td>
						<td> <OutputData /> </td>
					</tr>
					<tr>
						<td colSpan="2">
							<button className="submit" onClick={this.handleSubmit}>Submit</button>
						</td>
					</tr>
				</tbody>
			</table>
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
		store.dispatch(setInputData(event.target.value));
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
		this.handleFileChoosen = this.handleFileChoosen.bind(this);
	}
	
	handleFileChoosen(event) {
		let file = event.target.files[0]
		let fileReader = new FileReader();
		fileReader.onloadend = () => {
		      store.dispatch(setInputData(fileReader.result));
	    }
		fileReader.readAsText(file);
	}
	
	render() {
		return (
			<React.Fragment>
				<input type='file' id='file' className='input-file'
					accept='.txt' onChange={this.handleFileChoosen} />
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
			return <li>{el}</li>
		});
		return (
			<React.Fragment>
				<label htmlFor="output">Output:</label>
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