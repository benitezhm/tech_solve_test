import { SET_INPUT_DATA, SET_OUTPUT_DATA } from "./constants";

const initialState = {
  inputData: "",
  identification: "",
  outputData: []
};

const rootReducer = (state = initialState, action) => {
	switch(action.type) {
		case SET_INPUT_DATA:
			return Object.assign({}, state, {
		        inputData: action.payload,
		      });
		case SET_OUTPUT_DATA:
			return Object.assign({}, state, {
				outputData: action.payload,
			});
		default:
			return state;
	}
};

export default rootReducer;