package com.epam.tossing;

import java.security.SecureRandom;

public class TossSimulator {
	//-----------------------------------------------------------------------------fields
	private int headsCount;
	private int tailsCount;

	public static final int TOSSBOUND = 99999;
	//-----------------------------------------------------------------------------constructors
	public TossSimulator()
	{
		this.headsCount = 0;
		this.tailsCount = 0;
	}
	//-----------------------------------------------------------------------------
	//-----------------------------------------------------------------------------methods
	public void startToss(int tossesNumber)
	{
		SecureRandom randomNumber = new SecureRandom();
		for(int i = 0; i < tossesNumber; i++) {
			if(randomNumber.nextBoolean()) {
				this.headsCount++;
			}
		}
		this.tailsCount = tossesNumber - this.headsCount;
	}

	public void reset()
	{
		this.headsCount = 0;
		this.tailsCount = 0;
	}
	//-----------------------------------------------------------------------------getters
	public int getHeadsCount() {
		return this.headsCount;
	}

	public int getTailsCount() {
		return this.tailsCount;
	}
}