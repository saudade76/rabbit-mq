# *RabbitMQ Example*

 출처는 [이곳](https://oingdaddy.tistory.com/166).



### 🍊 실습

1. Docker에 RabbitMQ 설치 및 실행

````
# docker image 받아서 컨테이너 실행
# ID : admin
# PASSWORD : admin
docker run -d --name rabbitmq -p 5672:5672 -p 8080:15672 --restart=unless-stopped -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin rabbitmq:management
````

2. RabbitMQ Exchange, Queue 생성 및 Binding 설정
각각 [Exchanges], [Queues] 메뉴에서 생성하고, [Exchanges]에서 아까 생성한 Exchanges명을 눌러서 상세화면으로 들어간다.
아래 [Bindings]를 선택하고 정보를 입력해서 Binding 설정을 마친다.
(자세한 설명은 출처 참고)

3. PublisherApp(포트번호 9081), ConsumerApp(포트번호 9080) 각각 실행

4. 아래의 url로 접근하면 PublisherApp에서 RabbitMQ로, RabbitMQ에서 ConsumerApp으로 메시지가 전달된다.
````
localhost:9081/sample/queue
````
메시지가 전달되고 있다는 것은 아래의 url(RabbitMQ Management)로 접근하면 확인할 수 있다.
````
localhost:8080 # 1. docker run시 지정해준 포트
````

5. PublisherApp(포트번호 9081)만 실행되고 있는 상태라면 메시지가 큐에 쌓이기만 하므로 RabbitMQ Management에서 메시지가 쌓이고 있다는 것을 확인할 수 있다.

6. [Queues]에서 원하는 큐를 선택해서 상세화면으로 이동한 뒤, 아래의 [Publish message]를 선택해서 [Payload]에 메시지를 입력하고 전송할 수도 있다.
큐에 있는 메시지를 확인하고 싶은 경우 (우선 PublisherApp만 실행중인지 확인하고 메시지를 전송한 뒤) 큐 상세화면 아래의 [Get Message]를 선택하면 큐에 있는 메시지를 확인할 수 있다.
