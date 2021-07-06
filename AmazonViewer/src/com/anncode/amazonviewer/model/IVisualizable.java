package com.anncode.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {
	
	/**
	 * This method captures the exact display start time
	 * 
	 * @param dateI It is an {@code Date} object with the exact start time.
	 * @return Returns the captured date and time
	 * */
	Date startToSee(Date dateI);
	
	
	/**
	 * This method captures the exact display start and end time
	 * 
	 * @param dateI It is an object {@code Date} with the exact start time.
	 * @param dateF It is an object {@code Date} with the exact ending time.
	 * */
	void stopToSee(Date dateI, Date dateF);
	
}
