package br.usp.ime.dspbenchmarking;

import br.usp.ime.dspbenchmarking.DspThread.DspCallback;

public abstract class AudioStream {
	
	// timing
	protected long callbackPeriod = 0;
	protected long readTicks = 0;
	protected long sampleReadTime = 0;
	protected boolean isRunning = true;
	
	// DSP
	DspCallback dspCallback;

	public abstract short[] createBuffer();
	public abstract void scheduleDspCallback(DspCallback callback, long blockPeriodNanoseconds);
	public abstract void readLoop(short[] buffer);
	public abstract int blocks();
	public abstract void stopRunning();
	protected abstract int getMinBufferSize();
	
	public long getCallbackPeriod() {
		return callbackPeriod;
	}
	
	public long getReadTicks() {
		return readTicks;
	}
	
	public long getSampleReadTime() {
		return sampleReadTime;
	}

}
