package com.spring.restapi.models;

/**
 * @author sahithi
 *Sep 6, 2018
 * 
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

	private static final long serialVersionUID = 7406210628182440902L;
	
	private String weatherDescription;
	private double lon;
	private String name;
	private double lat;
	private Double temp;
	private Double speed;
	private Double temp_min;
	private Double temp_max;
	private Double feels_like;

	@Bean
	public Weather weather() {
		return new Weather();
	}
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(Weather weather) {
		// TODO Auto-generated constructor stub
	}

	public double getLat() {
		return lat;
	}

	@JsonProperty("lat")
	public void setLat(double lat) {
		this.lat = lat;
	}

	
	public String getName() {
		return name;
	}
	
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

    public Double getSpeed() {
	    return speed;
    }

    public void setSpeed(Double speed) {
	    this.speed = speed;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(Double feels_like) {
        this.feels_like = feels_like;
    }

    public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}

	@JsonProperty("lon")
	public double getLon() {
		return lon;
	}

	@JsonProperty("lon")
	public void setLon(double lon) {
		this.lon = lon;
	}
	
	@JsonProperty("coord")
	public void setCoord(Map<String, Object> coord) {
		setLon((double) coord.get("lon"));
		setLat((double) coord.get("lat"));
	}

    @JsonProperty("wind")
    public void setSpeeds(Map<String, Object> wind) {
        setSpeed((Double) wind.get("speed"));
    }

    @JsonProperty("main")
    public void setTemperature(Map<String, Object> main) {
        setTemp_min((Double) main.get("temp_min"));
        setTemp_max((Double) main.get("temp_max"));
        setFeels_like((Double) main.get("feels_like"));
        setTemp((Double) main.get("temp"));
    }
	
}
