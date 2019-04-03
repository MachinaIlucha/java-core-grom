CREATE TABLE ForumPosts(
    ID NUMBER,
    CONSTRAINT ForumPost_PK PRIMARY KEY (ID),
    IDSubcategory NUMBER,
    CONSTRAINT ForumPost_FK FOREIGN KEY (IDSubcategory) REFERENCES ForumSubcategories(ID),
    IDUser NUMBER,
    CONSTRAINT ForumPost_FK FOREIGN KEY (IDUser) REFERENCES Users(ID),
    ParentPost NUMBER,
    Title NVARCHAR2(90),
    Content CLOB,
    IsPoll NUMBER(1),
    DateCreated TIMESTAMP,
    IP NVARCHAR2(20)
);

CREATE TABLE ForumSubcategories(
    ID NUMBER,
    CONSTRAINT ForumSubcategories_PK PRIMARY KEY (ID),
    IDCategory NUMBER,
    CONSTRAINT ForumSubcategories_FK FOREIGN KEY (IDCategory) REFERENCES ForumCategories(ID),
    Title NVARCHAR2(45),
    Description CLOB,
    DateCreated TIMESTAMP,
    IP NVARCHAR2(20)
);

CREATE TABLE ForumCategories(
    ID NUMBER,
    CONSTRAINT ForumCategories_PK PRIMARY KEY (ID),
    Title NVARCHAR2(64),
    Description CLOB,
    DateCreated TIMESTAMP,
    IP NVARCHAR2(20)
);

CREATE TABLE Users(
    ID NUMBER,
    CONSTRAINT Users_PK PRIMARY KEY (ID),
    Nick NVARCHAR2(16),
    Password NVARCHAR2(128),
    Email NVARCHAR2(128),
    DateCreated TIMESTAMP,
    Karma FLOAT(9),
    IP NVARCHAR2(20)
);

CREATE TABLE ForumPollsOptions(
    ID NUMBER,
    CONSTRAINT ForumPollsOptions_PK PRIMARY KEY (ID),
    IDPost NUMBER,
    CONSTRAINT ForumPollsOptions_FK FOREIGN KEY (IDPost) REFERENCES ForumPosts(ID),
    Title NVARCHAR2(64),
    DateCreated TIMESTAMP
);

CREATE TABLE ForumPollsOptionsVotes(
    ID NUMBER,
    CONSTRAINT ForumPollsOptionsVotes_PK PRIMARY KEY (ID),
    IDPollOption NUMBER,
    CONSTRAINT ForumPollsOptionsVotes_FK FOREIGN KEY (IDPollOption) REFERENCES ForumPollsOptions(ID),
    IDUser NUMBER,
    CONSTRAINT ForumPollsOptionsVotes_FK FOREIGN KEY (IDUser) REFERENCES Users(ID),
    DateCreated TIMESTAMP,
    IP NVARCHAR2(20)
);
