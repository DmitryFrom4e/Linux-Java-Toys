1)   Используйте команды операционной системы Linux и создайте две новых директории – 
    «Игрушки для школьников» и «Игрушки для дошколят»

    mkdir "Игрушки для школьников" "Игрушки для дошколят"

2)   Создайте в директории «Игрушки для школьников» текстовые файлы - 
    «Роботы», «Конструктор», «Настольные игры»

    touch "Игрушки для школьников/Роботы" "Игрушки для школьников/Конструктор" "Игрушки для школьников/Настольные игры"

3)    Создайте в директории «Игрушки для дошколят» текстовые файлы 
    «Мягкие игрушки», «Куклы», «Машинки»

    touch "Игрушки для дошколят/Мягкие игрушки" "Игрушки для дошколят/Куклы" "Игрушки для дошколят/Машинки"

4)   Объединить 2 директории в одну «Имя Игрушки»

    mv "Игрушки для школьников" "Имя Игрушки/Игрушки для школьников" && mv "Игрушки для дошколят" "Имя Игрушки/Игрушки для дошколят"

5)   Переименовать директорию «Имя Игрушки» в «Игрушки»

    mv "Имя Игрушки" "Игрушки"

6)   Просмотреть содержимое каталога «Игрушки».

     ls Игрушки

7)   Установить и удалить snap-пакет. (Любой, какой хотите)

    sudo snap install vlc && sudo snap remove vlc

8)   Добавить произвольную задачу для выполнения каждые 3 минуты 
    (Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б).

    */3 * * * * cp ~/middle-linux/from/dirA/* ~/middle-linux/to/dirB/