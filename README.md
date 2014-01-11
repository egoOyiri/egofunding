egofunding
==========

Crowfunding WebSite for Ego Oyiri Project

## _Crowd Funding_ Template Project

Follow these steps to get started:

1. Git-clone this repository.

        $ git clone https://github.com/egoOyiri/egofunding.git egofunding 

2. Change directory into your clone:

        $ cd  egofunding

3. Launch SBT:

        $ sbt

4. Compile everything and run all tests:

        > test

5. Start the application:

        > re-start

6. Browse to http://localhost:8080/

7. Stop the application:

        > re-stop

8. Learn more at http://akka.io and http://spray.io/

9. Start hacking on `src/main/scala/org/egooyiri/EOService.scala`

## _Eclipse_ Integration

1. Launch SBT with eclipse argument:

         $ sbt eclipse

2. Test in Eclipse:

         In Eclipse run EOServiceSpec as JUnit or Scala Tests

## Deployment

Follow these steps to deploy:

1. Generate the Über-jar file:

         $ sbt assembly

2. run:
 
         $  java -jar target/scala-2.10/egofunding-assembly-0.1.jar

3. test:
        
         * in your favorite browser paste the URL _http://localhost:8080_
         
         * stop testing _http://localhost:8080/stop?method=post_
