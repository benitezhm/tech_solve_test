const React = require('react');
const ReactDOM = require('react-dom');
import store from "./store";
import { setInputData } from "./actions";
window.store = store;
//window.setInputData = setInputData;

class App extends React.Component {
	
	constructor(props) {
		super(props);
		this.handleSubmit =  this.handleSubmit.bind(this);
	}
	
	handleSubmit(event) {
		event.preventDefault();
		console.warn(store.getState().inputData);
		window.location = "#";
	}
	
	render() {
		return (
			<table>
				<tbody>
					<tr>
						<td> <InputData /> </td>
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

class OutputData extends React.Component {
	
	render() {
		return (
			<React.Fragment>
				<label htmlFor="output">Output:</label>
				<div className="output">
				</div>
			</React.Fragment>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)