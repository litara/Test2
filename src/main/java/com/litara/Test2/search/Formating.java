package com.litara.Test2.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.litara.Test2.model.Category;
import com.litara.Test2.model.Class;
import com.litara.Test2.model.Station;
import com.litara.Test2.model.Train;
import com.litara.Test2.model.Type;
import com.litara.Test2.model.Way;

public class Formating {
	public static List<TrainForList> formatingTrain(List<Train> list){
		List<TrainForList> trains = new ArrayList<TrainForList>();
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		for(Train i: list) {
			TrainForList train = new TrainForList();
			train.setName(i.getName());
			train.setDate_start(format.format(i.getDate_start()));
			train.setDate_stop(format.format(i.getDate_stop()));
			train.setId(i.getId());
			trains.add(train);
		}
		return trains;
	}
	public static List<StationForList> formatingStation(List<Station> list){
		List<StationForList> stations = new ArrayList<StationForList>();
		for(Station i: list) {
			StationForList station = new StationForList();
			station.setName(i.getName());
			station.setCountry(i.getCountry());
			station.setRegion(i.getRegion());
			station.setId(i.getId());
			stations.add(station);
		}
		return stations;
	}
	public static List<WayForList> formatingWay(List<Way> list){
		List<WayForList> ways = new ArrayList<WayForList>();
		for(Way i: list) {
			WayForList way= new WayForList();
			way.setId(i.getId());
			way.setStation(i.getStation().getName());
			way.setTrain(i.getTrain().getName());
			way.setStart_time(i.getStart_time().toString());
			way.setEnd_time(i.getEnd_time().toString());
			ways.add(way);
		}
		return ways;
	}
	public static List<ClassForList> formatingClass(List<Class> list){
		List<ClassForList> classes = new ArrayList<ClassForList>();
		for(Class i: list) {
			ClassForList classs= new ClassForList();
			classs.setId(i.getId());
			classs.setName(i.getName());
			classes.add(classs);
		}
		return classes;
	}
	public static List<TypeForList> formatingType(List<Type> list){
		List<TypeForList> types = new ArrayList<TypeForList>();
		for(Type i: list) {
			TypeForList type= new TypeForList();
			type.setId(i.getId());
			type.setName(i.getName());
			types.add(type);
		}
		return types;
	}
	public static List<CategoryForList> formatingCategory(List<Category> list){
		List<CategoryForList> categories = new ArrayList<CategoryForList>();
		for(Category i: list) {
			CategoryForList category= new CategoryForList();
			category.setId(i.getId());
			category.setName(i.getName());
			categories.add(category);
		}
		return categories;
	}
}
