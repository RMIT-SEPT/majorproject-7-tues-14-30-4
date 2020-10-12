# RMIT SEPT 2020 Major project

# Group 7-tues-14-30-4

## Members
* GUIDA, William (s3707064)
* ALVIANO, Angela (s3782264)
* CIMPEAN, Alin (s3780838)
* KERR, Grace (s3723465)
* KOH, Su-Kuen (s3769533)

## Records

* Github Repository : https://github.com/RMIT-SEPT/majorproject-7-tues-14-30-4
* Trello Board : https://trello.com/b/mdS1PQ3c
* Google Drive : https://drive.google.com/drive/folders/1NUceUUp3__5W7iXOujfTdvKTiu7o4TW4?usp=sharing
* CircleCi Link : https://app.circleci.com/pipelines/github/RMIT-SEPT/majorproject-7-tues-14-30-4
* AWS ECS ECR Repository (Backend) Image URI: 286824662367.dkr.ecr.us-east-1.amazonaws.com/septproject:latest
* AWS ECS ECR Repository (Frontend) Image URI: 286824662367.dkr.ecr.us-east-1.amazonaws.com/septprojectfrontend:latest

## Code documentation

[Quick Start](/docs/README.md) in `docs` folder

## Instructions for applciation

  ### Backend (Spring Boot)
  - build process
    1. `./mvnw package` will compile a JAR file.
    2. `docker build -f Dockerfile -t sept:backend .` builds an image based off the Dockerfile using that JAR file created.

  - deployment
    - After pushing your changes to git circleCi will run all unit, integration and system tests for the backend and frontend. If these tests pass then     circleCi will build and push an image to AWS as specified in the [config.yml](.circleci/config.yml) file.

  - running backend
    - locally
    * `docker run -p 8080:8080 sept:backend` will use the docker image built and run it locally on your machine.
    * 'http://localhost:8080/h2-console/' will give you access to the h2-console database GUI.
    - cloud
    * AWS...?
  
  ### Frontend (React)
  - build process
    1. `npm install` will install the dependencies from the local node_modules folder into package.json.
    
  - deployment
    - After pushing your changes to git circleCi will run all unit, integration and system tests for the backend and frontend. If these tests pass then     circleCi will build and push an image to an AWS ECR as specified in the [config.yml](.circleci/config.yml) file.
    - The front-end image has been deployed using AWS ECS

  - running frontend
    - locally
    * `npm start` will begin the frontend hitting 'http://localhost:3000' locally on your machine.
    - cloud
    * The front-end is accessible from: http://septelb-507656932.us-east-1.elb.amazonaws.com
