CREATE TABLE account (
	account_id VARCHAR(60) NOT NULL,
	password VARCHAR(255) NOT NULL,
	is_enabled BOOLEAN NOT NULL,
	create_date TIMESTAMPTZ NOT NULL,
	update_date TIMESTAMPTZ NOT NULL,
	PRIMARY KEY(account_id)
);

CREATE TABLE authorities (
	authorities_id VARCHAR(19) NOT NULL,
	account_id VARCHAR(60) NOT NULL,
	authority VARCHAR(10) NOT NULL,
	update_date TIMESTAMPTZ NOT NULL,
	PRIMARY KEY(authorities_id)
);

INSERT INTO account (account_id, password, is_enabled, create_date, update_date) VALUES ('administrator', '{bcrypt}$2a$08$83PnjgSZp6a2kVmZm7RCSeumfZoQhVODojQQgz348xpFpJAFRm8jW', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO authorities (authorities_id, account_id, authority, update_date) VALUES ('AT19700101000000000', 'administrator', 'ROLE_ADMIN', CURRENT_TIMESTAMP);