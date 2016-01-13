w pliku TestMenu należy :

  przed:
      ```js
      pasekMenu.add(menuPomocy);
      ```



      
 dodać linijke aby wyswietlac pomoc po prawej stronie:
```js
       pasekMenu.add(Box.createHorizontalGlue());
```




oraz uaktualnić *przeczytaj*
```js
   menuPomocy.add(new DzialanieTestowe("Przeczytaj")
      {
         public void actionPerformed(ActionEvent zdarzenie)
         {
             SwingUtilities.invokeLater(new Runnable(){
                 public void run(){
               	  utworzGui();
                 }

				private void utworzGui() {
					
					JFrame frame = new JFrame("Pomoc dla SOGiA");
					 JLabel label = new JLabel ("<html>"+
							 "Pomoc dla programu <b> SOGiA</b> System Obsługi Głosowania i Ankiet <br><hr>"+
							 "W Panelu Administracyjnym możesz zarządzać systemem.<br>"+
						     "Ankiety- tworzenie, edytowanie, usuwanie ankiet, pytań i odpowiedzi. <br>"+
							 "Mieszkaniec-dodawanie nowych mieszkańców, edycja istniejących danych <br>"+
						     "Wykres- możliwość utworzenia wykresu przedstawiającego wynik ankiety<br>"+
							 "Wyślij e-mail- możesz wysłać mieszkańcom przypomnienie o istniejących ankietach<br>");
					  frame.getContentPane().add(label);

					  frame.setSize(600,300);
					  frame.setVisible(true);
			
				}
                 });
         }
      });
```

      
      
   
