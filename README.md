# SA-Springboot-Simple
Simple Spring boot 
####################################################
path: /../src/main/java/com/sut/sa/cpe/
                                    |-./entity
                                        |-./User.java
                                        |-./Video.java
                                        |-./Comment.java
                                    |-./controller
                                        |-./UserController.java
                                        |-./VideoController.java
                                        |-./CommentController.java
                                    |-./repository
                                        |-./UserRepository.java
                                        |-./VideoRepository.java
                                        |-./CommentRepository.java
####################################################
~./mvnw spring-boot:run

output::
...
Comment(id=4, content=The first comment., userid=2, videoid=3)
User(id=1, username=Tanapon)
User(id=2, username=Sitthichai)
User(id=5, username=Somchai)

####################################################

