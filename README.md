## Alfresco FizzBuzz - Step 3-5

Short program that from a given range it returns all the numbers from the Fizz buzz game as such:
* 1: the number itself
* 2: ‘alfresco’ for numbers that are containing 3
* 3: ‘fizz’ for numbers that are multiples of 3
* 4: ‘buzz’ for numbers that are multiples of 5
* 5: ‘fizzbuzz’ for numbers that are multiples of 15

#### E.g. Range 1-20 outputs:
`1 2 alfresco 4 buzz fizz 7 8 fizz buzz 11 fizz alfresco 14 fizzbuzz 16 17 fizz 19 buzz`
`fizz: 4 buzz: 3 fizzbuzz: 1 alfresco: 2 integer: 10`

###Deploying the application
* mvn clean package
* docker build -t alfresco-spring-boot-docker
* docker run -p 8080:8080 alfresco-spring-boot-docker

