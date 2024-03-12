package com.iesVda.TestMongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoClients;
import static com.mongodb.MongoClientSettings.*;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class FilmDao implements DaoInterface<movies> {

	MongoClient conn;
	MongoDatabase database;
	MongoCollection<movies> collection;
	CodecRegistry pojoCodecRegistry;

	// Constructor
	public FilmDao() {
		conn = this.getConnection();
		database = conn.getDatabase("sample_mflix").withCodecRegistry(pojoCodecRegistry);
		collection = database.getCollection("movies", movies.class);
		/*
		 * conn = this.getConnection(); database =
		 * conn.getDatabase("sample_mflix").withCodecRegistry(pojoCodecRegistry);
		 * collection = database.getCollection("movies", movies.class);
		 */
	}

	private movies PopulateObject(Document MongoFilm) {

		movies AuxiliarFilm = new movies();
		List<String> auxList = new ArrayList<>();
		Document imdbDataDoc;
		imdb imdbData = new imdb();

		/**
		 * Reading String from Mongo Document
		 */

		auxList = MongoFilm.getList("directors", String.class);
		if (auxList != null) {
			AuxiliarFilm.setDirectors(auxList);
		} else {
			auxList.add("Null Error");
			AuxiliarFilm.setDirectors(auxList);
		}

		/**
		 * Reading embebed document from Mongo Document
		 */
		imdbDataDoc = (Document) MongoFilm.get("imdb");

		/**
		 * Reading Integer, Double from Mongo Document
		 */

		imdbData.setId(imdbDataDoc.getInteger("id"));
		imdbData.setRating(imdbDataDoc.getDouble("rating"));
		imdbData.setVotes(imdbDataDoc.getInteger("votes"));
		AuxiliarFilm.setImdbReference(imdbData);
		return AuxiliarFilm;
	}

	private MongoClient getConnection() {
		String url = "mongodb+srv://cristianchantada:cristian@cristian-instance.rrvjjrp.mongodb.net/?retryWrites=true&w=majority";
		pojoCodecRegistry = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
		pojoCodecRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				pojoCodecRegistry);
		MongoClient mongoClntObj = MongoClients.create(url);
		return mongoClntObj;

		/*
		 * String url =
		 * "mongodb+srv://cristianchantada:cristian@cristian-instance.rrvjjrp.mongodb.net/?retryWrites=true&w=majority";
		 * pojoCodecRegistry =
		 * fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
		 * fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		 * MongoClient mongoClntObj = MongoClients.create(url); return mongoClntObj;
		 */
	}

	/*
	 * public movies get(movies t) { movies AuxiliarFilm = new movies(); String
	 * FilmName = t.getTitle(); collection = database.getCollection("movies"); Bson
	 * equalComp = eq("title", FilmName); Document doc =
	 * collection.find(equalComp).first(); assert doc != null :
	 * "El doc ha llegado nulo"; AuxiliarFilm = PopulateObject(doc); return
	 * AuxiliarFilm; }
	 */

	public movies get(String Title) {
		movies aFilm = new movies();
		Bson equalComp = eq("title", Title);
		aFilm = collection.find(equalComp).first();
		return aFilm;

		/*
		 * movies AuxiliarFilm = new movies(); collection =
		 * database.getCollection("movies"); Bson equalComp = eq("title", Title);
		 * Document doc = collection.find(equalComp).first(); assert doc != null :
		 * "El doc ha llegado nulo"; AuxiliarFilm = PopulateObject(doc); return
		 * AuxiliarFilm;
		 */
	}

	@Override
	public List<movies> getAll() {
		return null;
	}

	@Override
	public void save(movies newFilm) {
		collection.insertOne(newFilm);

		/*
		 * List<String> genres = new ArrayList<>(); genres = newFilm.getGenres();
		 * 
		 * Document filmDataDoc = new Document("_id", new ObjectId());
		 * filmDataDoc.append("plot", newFilm.getPlot()).append("genres",
		 * List.of(genres.get(0), genres.get(1))) .append("runtime",
		 * newFilm.getRuntime()) .append("cast", List.of(newFilm.getCast().get(0),
		 * newFilm.getCast().get(1), newFilm.getCast().get(2),
		 * newFilm.getCast().get(3))) .append("poster",
		 * newFilm.getPoster()).append("title", newFilm.getTitle()).append("fullplot",
		 * newFilm.getFullplot()).append("languages",
		 * List.of(newFilm.getLanguages().get(0))) .append("released",
		 * newFilm.getReleasedDate()).append("imdb", newFilm.getImdbReference());
		 * 
		 * collection = database.getCollection("movies");
		 * collection.insertOne(filmDataDoc);
		 */
	}

	@Override
	public void update(movies film, String[] params) {

	}

	@Override
	public void delete(movies film) {

	}

	@Override
	public movies get(movies t) {
		// TODO Auto-generated method stub
		return null;
	}

}
