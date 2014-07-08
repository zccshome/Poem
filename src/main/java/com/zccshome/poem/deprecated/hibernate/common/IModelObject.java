/*
 * Copyright 2006 Centenum Software Solutions, Inc. All rights reserved.
 * CENTENUM PROPRIETARY/CONFIDENTIAL. 
 */
package com.zccshome.poem.deprecated.hibernate.common;


/**
 * base interface for all model class
 * 
 * @author zhang tiange
 * 
 */
public interface IModelObject {
	/**
	 * get object id
	 * 
	 * @return the object id
	 */
	Integer getId();

	/**
	 * set object id
	 * 
	 * @param id
	 *            the object id
	 */
	void setId(Integer id);

}
