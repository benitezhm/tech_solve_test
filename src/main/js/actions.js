import { SET_INPUT_DATA, SET_OUTPUT_DATA, SET_IDENTIFICATION } from "./constants";

export const setInputData = inputData => ({ type: SET_INPUT_DATA, payload: inputData }),
			setOutputData = outputData => ({ type: SET_OUTPUT_DATA, payload: outputData }),
			setIdentification = identification => ({ type: SET_IDENTIFICATION, payload: identification });