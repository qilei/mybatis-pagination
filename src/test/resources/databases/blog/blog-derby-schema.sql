--
--    Copyright 2009-2012 the original author or authors.
--
--    Licensed under the Apache License, Version 2.0 (the "License");
--    you may not use this file except in compliance with the License.
--    You may obtain a copy of the License at
--
--       http://www.apache.org/licenses/LICENSE-2.0
--
--    Unless required by applicable law or agreed to in writing, software
--    distributed under the License is distributed on an "AS IS" BASIS,
--    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
--    See the License for the specific language governing permissions and
--    limitations under the License.
--

DROP TABLE post;
DROP TABLE author;

CREATE TABLE author (
id                INT NOT NULL GENERATED BY DEFAULT AS IDENTITY (START WITH 10000),
username          VARCHAR(255) NOT NULL,
password          VARCHAR(255) NOT NULL,
email             VARCHAR(255) NOT NULL,
bio               LONG VARCHAR,
favourite_section VARCHAR(25),
PRIMARY KEY (id)
);

CREATE TABLE post (
id          INT NOT NULL GENERATED BY DEFAULT AS IDENTITY,
author_id   INT NOT NULL,
created_on  TIMESTAMP NOT NULL,
section     VARCHAR(25) NOT NULL,
subject     VARCHAR(255) NOT NULL,
body        CLOB NOT NULL,
draft       INT NOT NULL,
PRIMARY KEY (id),
FOREIGN KEY (author_id) REFERENCES author(id)
);
