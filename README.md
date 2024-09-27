# Fragments

Задание лежит здесь:
https://kazakovanton.notion.site/Fragments-68897f1d94f143ec8db2ae9aa3e2aef6

# Fragments

Цель работы: научиться работать с Fragment API, научиться реализовывать обмен данными между фрагментами на разных уровнях

## Задание #1

1. По клику на кнопку вызовите фрагмент транзакцию которая открывает **FragmentA**

2. В FragmentA добавьте кнопку, которая открывает фрагмент FragmentAA,
   при этом он является child фрагментом для **FragmentA**.
   При открытии **FragmentAA** передайте в него цвет, полученные из рандомайзера **ColorGenerator**

3. В **FragmentAA** также добавьте кнопку которая открывает **FragmentAB**,
   который также является чайлдом **FragmentA**.
   Также передайте в аргументы цвет полученный из **ColorGenerator**

4. Реализуйте обработку нажатия на кнопку “Назад”, используя **OnBackPressedDispatcher**,
   таким образом что по нажатию из стека фрагментов удаляется один фрагмент,
   после того как размер стека = 1, закрывайте активити

## Задание #2

Реализуйте два фрагмента **FragmentBA** и **FragmentBB** и реализуйте обмен данными
от фрагмента **FragmentBB** к фрагменту **FragmentBA**:

1. Если девайс находится в landscape ориентации то расположите фрагменты на одном уровне иерархии.
   В фрагмент **FragmentBB** добавьте кнопку, по нажатию на которую программа получит цвет из
   рандомайзера **ColorGenerator** и передаст его в FragmentBA, используя **FragmentResultListener**

2. Если девайс находится в portrait ориентации, добавьте в FragmentBA кнопку,
   по нажатию на которой будет открываться FragmentBB, на том же уровне иерархии,
   что и FragmentBA. В FragmentBB добавьте кнопку, которая вернет результат на FragmentBA