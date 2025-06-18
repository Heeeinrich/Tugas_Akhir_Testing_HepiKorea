Feature: Product Search
  Pengujian fitur Searcg oleh user
  Pengguna dapat mencari produk spesifik menggunakan Searchbar


  Scenario Outline: Cari produk dari halaman product
    Given user berada di homepage
    When user memilih tab Product pada navigation bar
    And user memasukan kata kunci produk "<Keyword Valid>" di halaman produk
    Then sistem menampilkan hasil pencarian produk


    Examples:
      |Keyword Valid |
      |Ouija         |
      |Kemeja        |
      |Samsung       |
      |              |


  Scenario Outline: Gagal Cari produk dari halaman product
    Given user berada di homepage
    When user memilih tab Product pada navigation bar
    And user memasukan kata kunci produk tidak valid "<Keyword_Tidak_Valid>" di halaman produk
    Then sistem tidak menampilkan hasil pencarian produk


    Examples:
      |Keyword_Tidak_Valid|
      |Rolex              |
