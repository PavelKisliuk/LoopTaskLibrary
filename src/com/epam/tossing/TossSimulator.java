package com.epam.tossing;

import java.security.SecureRandom;

public class TossSimulator {
	//-----------------------------------------------------------------------------fields
	private int headsCount;
	private int tailsCount;
	private int tossesCounter;

	public static final int TOSSBOUND = 99999;
	//-----------------------------------------------------------------------------constructors
	public TossSimulator()
	{
		this.headsCount = 0;
		this.tailsCount = 0;
		this.tossesCounter = 0;
	}
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------methods
	public void startToss(int tossesNumber)
	{
		SecureRandom randomNumber = new SecureRandom();
		while(tossesNumber > this.tossesCounter++) {
			if((randomNumber.nextInt() % 2) != 0) {
				this.headsCount++;
			}else {
				this.tailsCount++;
			}
		 }
	}

	public void reset()
	{
		this.headsCount = 0;
		this.tailsCount = 0;
		this.tossesCounter = 0;
	}
	//-----------------------------------------------------------------------------getters
	public int getHeadsCount() {
		return this.headsCount;
	}

	public int getTailsCount() {
		return this.tailsCount;
	}
}
