CREATE TABLE IF NOT EXISTS postit.note (
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(100),
	content VARCHAR(256),
	category_id INT,
	create_date TIMESTAMP DEFAULT 0,
	update_date TIMESTAMP DEFAULT 0,
	PRIMARY KEY (id),	
	FOREIGN KEY (category_id) REFERENCES postit.category(id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS postit.category (
	id INT NOT NULL,
	name VARCHAR(100),
	PRIMARY KEY (id)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;