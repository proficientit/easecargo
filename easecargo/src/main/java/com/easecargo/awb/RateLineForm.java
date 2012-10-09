package com.easecargo.awb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RateLineForm extends RateLine {

	private List<Dimension> dims = new ArrayList<Dimension>();

	public List<Dimension> getDims() {
		return dims;
	}

	public void setDims(List<Dimension> dims) {
		this.dims = dims;
	}
	
	public static List<RateLineForm> paddRateLineList(List<RateLineForm> rateLines){
		for(int i=rateLines.size(); i < 4 ; i++){
			RateLineForm rl = new RateLineForm();			       
	//		rl.setAwb(awb);			
			rateLines.add(rl);		
		}  
		return rateLines;
	}
	
	public static List<RateLineForm> slimRateLineList(List<RateLineForm> rateLines, AWB awb){
		Iterator<RateLineForm> iter3 = rateLines.iterator();
		while(iter3.hasNext()){
			RateLineForm rateLine = iter3.next();
			if(rateLine.getNoOfPieces() == null || rateLine.getNoOfPieces()== 0){
				iter3.remove();
			} else {
				rateLine.setAwb(awb);
			}			
		}
		return rateLines;
	}	
	
	public static List<Dimension> paddDimList(List<Dimension> dims){
		for(int i=dims.size(); i < 2 ; i++){
			Dimension dim = new Dimension();			       
			dims.add(dim);		
		}  
		return dims;
	}
	
	public static List<Dimension> slimDimList(List<Dimension> dims, RateLine rateLine){
		Iterator<Dimension> iter3 = dims.iterator();
		while(iter3.hasNext()){
			Dimension dim = iter3.next();
			if(dim.getHeight() == null || dim.getHeight()== 0){
				iter3.remove();
			} else {
				dim.setRateLine(rateLine);
			}
		}		
		return dims;
	}		
	
	public static List<RateLine> toModels(List<RateLineForm> list){
			List<RateLine> models = new ArrayList<RateLine>();
			for(RateLineForm rateLineForm : list){
				models.add(rateLineForm.toModel());
			}
			return models;
	}
	
	public static List<RateLineForm> toForms(List<RateLine> list){
		List<RateLineForm> forms = new ArrayList<RateLineForm>();
		for(RateLine  rateLine  : list){
			forms.add(RateLineForm.toForm(rateLine));
		}
		return forms;
}	
	
	public  RateLine toModel(){
		RateLine model= new RateLine();
		
		model.setAwb(getAwb());
		model.setChargedWeight(getChargedWeight());
		model.setCommodityItemNumber(getCommodityItemNumber());
		model.setConversionFactor(getConversionFactor());
		model.setDimensions(dimList2Set(slimDimList(getDims(),model))); 
		model.setGrossWeight(getGrossWeight());
		model.setGrossWeightUnit(getGrossWeightUnit());
		model.setItemDescritpion(getItemDescritpion());
		model.setItemNumber(getItemNumber());
		model.setNatureOfGoods(getNatureOfGoods());
		model.setNoOfPieces(getNoOfPieces());
		model.setRateCharge(getRateCharge());
		model.setRateClassCode(getRateClassCode());
		model.setRateLineId(getRateLineId());
		model.setRcp(getRcp());
		model.setShipperLoadCount(getShipperLoadCount());
		model.setTotal(getTotal());
		model.setVolumeAmount(getVolumeAmount());
		
		return model;
	}
	
	public static RateLineForm toForm(RateLine rateline){
		RateLineForm form= new RateLineForm();
		
		form.setAwb(rateline.getAwb());
		form.setChargedWeight(rateline.getChargedWeight());
		form.setCommodityItemNumber(rateline.getCommodityItemNumber());
		form.setConversionFactor(rateline.getConversionFactor());
		form.setDims(paddDimList(dimSet2List(rateline.getDimensions())));
		form.setGrossWeight(rateline.getGrossWeight());
		form.setGrossWeightUnit(rateline.getGrossWeightUnit());
		form.setItemDescritpion(rateline.getItemDescritpion());
		form.setItemNumber(rateline.getItemNumber());
		form.setNatureOfGoods(rateline.getNatureOfGoods());
		form.setNoOfPieces(rateline.getNoOfPieces());
		form.setRateCharge(rateline.getRateCharge());
		form.setRateClassCode(rateline.getRateClassCode());
		form.setRateLineId(rateline.getRateLineId());
		form.setRcp(rateline.getRcp());
		form.setShipperLoadCount(rateline.getShipperLoadCount());
		form.setTotal(rateline.getTotal());
		form.setVolumeAmount(rateline.getVolumeAmount());
		
		return form;
	}

	private static List<Dimension> dimSet2List(Set<Dimension> dimset){
		List<Dimension> dimlist = new ArrayList<Dimension>();
		if(dimset != null){ 
			dimlist.addAll(dimset);
		}
		return dimlist;
	}
	
	private static Set<Dimension> dimList2Set(List<Dimension> dimlist){
		Set<Dimension> dimset = new HashSet<Dimension>();
		dimset.addAll(dimlist);
		return dimset;
	}
	
	public static List<RateLine> rateLineSet2List(Set<RateLine> set){
		List<RateLine> list = new ArrayList<RateLine>();
		if(set != null){ 			 	 
			list.addAll(set);
		}
		return list;
	}
	
	public static Set<RateLine> rateLineList2Set(List<RateLine> list){
		Set<RateLine> set = new HashSet<RateLine>();
		set.addAll(list);
		return set;
	}	
}
