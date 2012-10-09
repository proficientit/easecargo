package com.easecargo.awb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sample {
	private String name;
	
	private Set<SampleInner> sampleInners =  new HashSet<SampleInner>();

	public Set<SampleInner> getSampleInners() {
		return sampleInners;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSampleInners(Set<SampleInner> sampleInners) {
		this.sampleInners = sampleInners;
	}
	
	public void addSampleInner (SampleInner sampleInner) { 
		this.sampleInners.add(sampleInner);
	}
	
	
	public static Sample  buildSample(){
		Sample sample = new Sample();
		SampleInner inner1 = new SampleInner("Name1","Value1");
		SampleInner inner2 = new SampleInner("Name2","Value2");
		SampleInner inner3 = new SampleInner("Name3","Value3");
		
		Set<SampleInner> list = new HashSet<SampleInner>();
		list.add(inner1);
		list.add(inner2);
		list.add(inner3);
		
		sample.setSampleInners(list);
		
		return sample;
	}
}
