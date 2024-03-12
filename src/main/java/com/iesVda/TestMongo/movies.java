package com.iesVda.TestMongo;

import java.lang.reflect.*;
import java.util.Date;
import java.util.List;

public class movies {

	private long _id;
	private String plot;
	private List<String> genres;
	private int runtime;
	private List<String> cast;
	private int num_mflix_comments;
	private String poster;
	private String title;
	private String fullplot;
	private List<String> languages;
	private Date released;
	private List<String> directors;
	private List<String> writers;
	private awards awards;
	private Date lastupdated;
	private int year;
	private imdb imdb;
	private List<String> countries;
	private String type;
	private tomatoes tomatoes;

	Field[] classfield;

	public Field[] studyAClass(Class<?> aClass) {
		Field[] theFields = aClass.getDeclaredFields();
		return theFields;
	}

	public movies() {
	}

	public movies(String title) {
		this.title = title;
	}

	public long get_id() {
		return _id;
	}

	public void set_id(long _id) {
		this._id = _id;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public int getNum_mflix_comments() {
		return num_mflix_comments;
	}

	public void setNum_mflix_comments(int num_mflix_comments) {
		this.num_mflix_comments = num_mflix_comments;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullplot() {
		return fullplot;
	}

	public void setFullplot(String fullplot) {
		this.fullplot = fullplot;
	}

	public List<String> getLanguages() {
		return languages;
	}

	public void setLanguages(List<String> languages) {
		this.languages = languages;
	}

	public Date getReleasedDate() {
		return released;
	}

	public void setReleasedDate(Date released) {
		this.released = released;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public List<String> getWriters() {
		return writers;
	}

	public void setWriters(List<String> writers) {
		this.writers = writers;
	}

	public Object getAwards() {
		return awards;
	}

	public void setAwards(awards awards) {
		this.awards = awards;
	}

	public Date getLastupdatedsed() {
		return lastupdated;
	}

	public void setLastupdatedsed(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Object getImdbReference() {
		return imdb;
	}

	public void setImdbReference(imdb imdb) {
		this.imdb = imdb;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(tomatoes tomatoes) {
		this.tomatoes = tomatoes;
	}

}
