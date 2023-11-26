
CREATE TABLE game_activity (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT,
                               activityName VARCHAR(255) NOT NULL,
                               activityDesc TEXT,
                               type INT NOT NULL,
                               startTime DATETIME,
                               endTime DATETIME
);

CREATE UNIQUE INDEX idx_unique_activityName ON game_activity (activityName);
