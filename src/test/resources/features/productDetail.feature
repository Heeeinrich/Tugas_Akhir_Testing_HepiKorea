Feature: Product Detail
  Pengujian fitur Product Detail oleh user

  Background:
    Given user membuka platform HepiKorea

  Scenario: menambahkan produk yang valid dari homepage
    Given user berada di halaman homepage
    When user memilih produk "Uniqlo"
    And user mengklik tombol Buy
    Then user akan diarahkan ke dalam halaman product detail
    And user memilih jumlah product
    And user mengklik tombol Add to Cart
    Then product akan disimpan dan ditampilkan di cart

  Scenario: menambahkan produk yang valid dari halaman product
    Given user berada di halaman homepage
    When user memilih tab Product pada navigation bar
    Then user akan diarahkan ke dalam halaman product
    And user memilih produk "Uniqlo"
    And user mengklik tombol Buy
    Then user akan diarahkan ke dalam halaman product detail
    And user memilih jumlah product
    And user mengklik tombol Add to Cart
    Then product akan disimpan dan ditampilkan di cart

  Scenario: melihat detail produk yang tidak ada dari homepage
    Given user berada di halaman homepage
    When user memilih produk "Rolex"
    And user mengklik tombol Buy
    Then sistem tidak mengarahkan pengguna ke dalam halaman product detail

  Scenario: melihat detail produk yang tidak ada dari halaman product
    Given user berada di halaman homepage
    When user memilih tab Product pada navigation bar
    Then user akan diarahkan ke dalam halaman product
    And pengguna memilih tab Product pada navigation bar
    And user memilih produk "Rolex"
    And user mengklik tombol Buy
    Then sistem tidak mengarahkan pengguna ke dalam halaman product detail

  Scenario: gagal menambahkan produk yang valid karena keranjang penuh dari homepage
    Given user berada di halaman homepage
    When user memilih produk "Uniqlo"
    And user mengklik tombol Buy
    Then user akan diarahkan ke dalam halaman product detail
    And user memilih jumlah product
    And user mengklik tombol Add to Cart
    Then product gagal disimpan dan ditampilkan di cart

  Scenario: gagal menambahkan produk yang valid karena keranjang penuh dari halaman product
    Given user berada di halaman homepage
    When user memilih tab Product pada navigation bar
    Then user akan diarahkan ke dalam halaman product
    And user memilih produk "Uniqlo"
    And user mengklik tombol Buy
    Then user akan diarahkan ke dalam halaman product detail
    And user memilih jumlah product
    And user mengklik tombol Add to Cart
    Then product gagal disimpan dan ditampilkan di cart