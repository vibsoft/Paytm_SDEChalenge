# PaytmLabs SDE Challenge

## Coding Question

Write an interface for a data structure that can provide the moving average of the last N elements added, add elements to the structure and get access to the elements. Provide an efficient implementation of the interface for the data structure.

### Minimum Requirements

1. Provide a separate interface (IE `interface`/`trait`) with documentation for the data structure
2. Provide an implementation for the interface
3. Provide any additional explanation about the interface and implementation in a README file.


**There are 2 solution provided**:

1. Solution1:
  Implementation of MovingAverage based on assumptions that moving N  provided as function's parameter getMovingAverage(int MovingN) and we persist all added items.
  Complexity for getMovingAverage(int MovingN) is O(n) - we will scan all items in the list

2. Solution2:
  Implementation of MovingAverageEff based on assumptions that moving N provided ones in constructor and only items used in Moving N calculation are persists.
  Complexity for getMovingAverage() is O(1):
  - add item to the end of LinkedList to end is O(1)
  - remove first item from head of LinkedList is O(1)



## Design Question

Design A Google Analytic like Backend System.
We need to provide Google Analytic like services to our customers. Please provide a high level solution design for the backend system. Feel free to choose any open source tools as you want.

### Requirements

1. Handle large write volume: Billions of write events per day.
2. Handle large read/query volume: Millions of merchants wish to gain insight into their business. Read/Query patterns are time-series related metrics.
3. Provide metrics to customers with at most one hour delay.
4. Run with minimum downtime.
5. Have the ability to reprocess historical data in case of bugs in the processing logic.


** Solution** 
To implement requirements we would need the following high level components:
- load balancing functionality to ensure high performance under high volume events number
- services based on microservice architecture for horizontal scalability
- hi-performance, fault-tolerant distributed streaming platform for asynchronous processing  - Kafka.
- scalable and high-performing data storage  noSQL db (Casandra)  - Grafana and Influx db for time metrics service

The following set of microservices will be used (diagram in PaytmLabs_DesignGoogleAnalitics.pptx) : 
1. events-accept: RESTful microservice which will accept customer events and have Kafka producers to publish data messages into Kafka topic streams. 
   microservices can be scalable horizontally by using Load Balancer to implement large volume performance and zero time down requirements 
   Kafka message partitioning could be used for parallel message handling on Kafka clusters.
   Kafka cluster configured with replication-factor 3 for reliability and fault tolerance 
2. kafka-process-persist-history: microservice with Kafka consumer receiver which will consume data from Kafka cluster and persist data into noSQL db for persisting all data into historical data storage
3. kafka-process-persist-metrics: microservice with Kafka consumer receiver which will consume data from Kafka cluster and persist data into storage(like InfluxDB) for consuming from health-time-metrics service
4. health-time-metrics: microservice with Grafana which present time-metrix to client while consuming data from time-metrix data storage (like InfluxDB)
5. history-time-metrics: microservice to initiate rebuilding time-metrics or microservice could be based on Spring Data Batch to republish data to time-metrix data storage or provide different set of reports based on batch all data available in historical data store 
