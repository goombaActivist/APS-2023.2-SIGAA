Vim�UnDo� ��0�)��X?�� �lH�#N�A�k�~�rI�D�h      >    constraint teaches_pk PRIMARY KEY(idclass, idprofessor) );                             e�Z    _�                             ����                                                                                                                                                                                                                                                                                                                                                             e�0     �                   �               5��                                         �       5�_�                            ����                                                                                                                                                                                                                                                                                                                                                             e�1     �                  5��                                                  5�_�                           ����                                                                                                                                                                                                                                                                                                                                                             e�2     �                create table teaches(5��                                              �                                              �                                              �                                              �                                              5�_�                           ����                                                                                                                                                                                                                                                                                                                                                             e�9     �               7    idclass integer references professors(idprofessor),5��                                             5�_�                            ����                                                                                                                                                                                                                                                                                                                                                             e�=     �               8    idcourse integer references professors(idprofessor),5��               
          :       
              5�_�                       &    ����                                                                                                                                                                                                                                                                                                                                                             e�>     �               3    idcourse integer references class(idprofessor),5��       &                 @                     �       &                 @                     �       &                 @                     �       &                 @                     �       &                 @                     5�_�                           ����                                                                                                                                                                                                                                                                                                                                                             e�E     �               4    idprofessor integer references classes(idclass),5��                        N                     5�_�      	                     ����                                                                                                                                                                                                                                                                                                                                                             e�H     �               0    idclass integer references classes(idclass),5��                        i                     5�_�      
           	      &    ����                                                                                                                                                                                                                                                                                                                                                             e�K     �               /    idclass integer references course(idclass),5��       &                 p                     5�_�   	              
          ����                                                                                                                                                                                                                                                                                                                                                             e�N     �               >    constraint teaches_pk PRIMARY KEY(idclass, idprofessor) );5��              
          �       
              5�_�   
                    2    ����                                                                                                                                                                                                                                                                                                                                                             e�S     �               A    constraint curriculum_pk PRIMARY KEY(idclass, idprofessor) );5��       2                 �                     5�_�                       )    ����                                                                                                                                                                                                                                                                                                                                                             e�U     �               8    constraint curriculum_pk PRIMARY KEY(idclass, id) );5��       )                 �                     �       )                 �                     �       )                 �                     �       )                 �                     �       )                 �                     5�_�                        5    ����                                                                                                                                                                                                                                                                                                                                                             e�Y    �               9    constraint curriculum_pk PRIMARY KEY(idcourse, id) );5��       5                  �                      �       3                 �                     �       3                 �                     �       3                 �                     �       3                 �                     5��