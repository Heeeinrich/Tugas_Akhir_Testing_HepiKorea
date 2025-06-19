Feature: Product Detail
  Pengujian fitur Product Detail oleh user

  Scenario: Menambahkan produk yang valid dari homepage
    Given user telah melakukan login sebagai customers
    When user memilih tab Product pada navigation bar
    And user memilih produk bernama Ouija
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk
    And user mengklik tombol Add to Cart
    Then user mendapatkan pesan sukses menambahkan

  Scenario: Gagal menambahkan produk karena tidak login
    Given user berada di homepage
    When user memilih tab Product pada navigation bar
    And user memilih produk bernama Ouija
    Then user akan diarahkan ke halaman product detail
    And user memilih jumlah produk
    And user mengklik tombol Add to Cart
    Then user tidak mendapatkan pesan sukses menambahkan
