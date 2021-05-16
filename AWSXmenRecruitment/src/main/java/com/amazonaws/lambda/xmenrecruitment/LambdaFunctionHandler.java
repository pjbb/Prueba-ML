package com.amazonaws.lambda.xmenrecruitment;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<Request, String> {

	@Override
	public String handleRequest(Request input, Context context) {
		context.getLogger().log("Input: " + input.getDna().toString());
		try {
			boolean resp = MutantXmen.getInstance().isMutant(input.getDna());

			if (resp)
				return "Successful: Code 200";
			else
				return "Successful: Code 403";
			
		} catch (Exception e) {
			return "ERROR: " + e.getMessage();
		}
	}

}
