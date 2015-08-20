package com.yikangyiliao.pension.common.error;


/**
 * 
 * @author liushuaic
 * @date 2015/07/30 15:10
 * @desc 异常静态类
 * 
 * **/
public class ExceptionConstants {
	

	public enum responseSuccess{
		responseSuccess("000000","操作成功！");
		
		public String code;
		public String message;
		private responseSuccess(String code,String message){
			this.code=code;
			this.message=message;
		}
	}
	
	/**
	 * 参数异常枚举类
	 * @author liushuaic
	 * @date	2015/07/30 15:18
	 * */
	public enum parameterException{
		parameterException("000001","参数类型异常！"),
		accessTiketException("000002","accessTiket校验异常！");
		public String errorCode;
		public String errorMessage;
		private parameterException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	public enum systemException{
		systemException("999999","系统异常！");
		public String errorCode;
		public String errorMessage;
		private systemException(String errorCode,String errorMessage){
			this.errorCode=errorCode;
			this.errorMessage=errorMessage;
		}
	}
	
}
