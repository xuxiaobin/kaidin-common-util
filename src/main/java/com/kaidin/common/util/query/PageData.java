/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.query;

import com.kaidin.common.util.ToString;

/**
 * 用于接口的返回值
 * 
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2015-6-23下午01:51:48
 */
public class PageData<T> extends ToString {
	private static final long serialVersionUID = 8125027060909448117L;
	/** 是否调用成功 */
	private boolean           success;
	/** 错误代码（可以自己定义） */
	private String            errCode;
	/** 出错信息 */
	private String            errMsg;
	/** 记录总数，主要用于分页展示，默认为-1 */
	private Integer           totalCount;
	/** 记录开始部分，默认为1 */
	private Integer           offset;
	/** 记录条数限制，默认为20 */
	private Integer           limit;
	/** 数据模型 */
	private T                 data;
	/** 链路信息 */
	private String 			  trace;


	public PageData() {
	}

	public PageData(PageRequest pageLoadConfig) {
		if (null == pageLoadConfig) {
			return;
		}
		offset = pageLoadConfig.getOffset();
		limit = pageLoadConfig.getLimit();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public Integer getTotalCount() {
		if (null == totalCount) {
			return null;
		}
		// 记录总数至少为0
		return Math.max(totalCount, 0);
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getOffset() {
		if (null == offset) {
			return null;
		}
		// 记录数从1开始
		return Math.max(offset, 1);
	}

	public void setOffset(Integer offset) {
		// 记录数从1开始
		this.offset = offset;
	}

	public Integer getLimit() {
		if (null == limit) {
			return null;
		}
		// 记录数量最少一条，否则没有意义
		return Math.max(limit, 1);
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}
}
