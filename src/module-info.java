module OOAD_PROJECT {
	opens view.scene.authentication;
	opens controller;
	opens database;
	opens view.stage;
	opens main;
	opens model;

	requires java.sql;
	requires javafx.base;
	requires javafx.graphics;
	requires javafx.controls;
}