# project-control-system
      +---------+          +------------+           +---------+
      |  core   |          | persistence|           | service |
      +---------+          +------------+           +---------+
            ^                     ^                      ^
            |                     |                      |
            |                     |                      |
            +----------+----------+----------------------+
                       |                       
                       |
                       v                       
                 +---------+                   
                 |   api   |                  
                 +---------+                    
                       ^                       
                       |                        
                       |                        
            +----------+----------+                         
            |       client       |                         
            +-------------------+ 
			
			
core - модуль, содержащий общие классы и интерфейсы для всего проекта, такие как модели данных, исключения и т.д.

persistence - модуль, содержащий классы для работы с базой данных, например, DAO-классы и миграции базы данных.

service - модуль, содержащий бизнес-логику приложения, такие как классы сервисов, которые используются для работы с моделями данных и выполнения задач.

api - модуль, содержащий классы для обработки HTTP-запросов и предоставления REST API.

client - модуль, содержащий классы для взаимодействия с другими сервисами или API, например, классы для отправки электронных писем.