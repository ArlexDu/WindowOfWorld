package edu.tongji.amazing.model;

import org.springframework.stereotype.Component;

@Component("result")
public class TestingResult {

	public String function_name;
	public String real_result;
	public String predict_result;
	public String result;
	public String getFunction_name() {
		return function_name;
	}
	public void setFunction_name(String function_name) {
		this.function_name = function_name;
	}
	public String getReal_result() {
		return real_result;
	}
	public void setReal_result(String real_result) {
		this.real_result = real_result;
	}
	public String getPredict_result() {
		return predict_result;
	}
	public void setPredict_result(String predict_result) {
		this.predict_result = predict_result;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
}
