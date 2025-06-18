Feature: Product Filter
  Pengujian fitur Filter oleh user
  Pengguna dapat mencari produk spesifik menggunakan filter

  Background:
    Given user berada di homepage

  Scenario: Mencari produk spesifik menggunakan filter
    When user memilih tab Product pada navigation bar melalui homepage
    And user memilih kategori Beauty
    And user memasukan minimum price 100000
    And user memasukan maximum price 300000
    And user memilih sort by Most Ordered
    Then sistem akan menampilkan produk berdasarkan filter

  Scenario: Mencari produk yang tidak ada menggunakan filter
    When user memilih tab Product pada navigation bar melalui homepage
    And user memilih kategori Beverage
    Then sistem tidak akan menampilkan produk karena tidak ada

