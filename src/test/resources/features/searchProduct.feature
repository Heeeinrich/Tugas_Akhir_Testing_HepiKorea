Feature: Product Search
  Pengujian fitur Searcg oleh user
  Pengguna dapat mencari produk spesifik menggunakan Searchbar


  Scenario Outline: Cari produk dari halaman product
    Given user berada di homepage
    When user memilih tab Product pada navigation bar
    And user memasukan kata kunci produk "<Keyword>" di halaman produk
    Then sistem menampilkan hasil pencarian produk


    Examples:
      |Keyword  |
      |Ouija    |
      |Kemeja   |
      |Samsung  |
      |         |
      |Rolex    |