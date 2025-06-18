Feature: Checkout Produk
  Pengujian fitur checkout oleh customer pada platform HepiKorea.

  Background:
    Given user telah melakukan login sebagai customers
    And user berada di homepage

  Scenario: Berhasil melakukan checkout produk dari halaman Cart
    When user memilih tab Cart pada navigation bar
    Then user akan diarahkan ke dalam halaman keranjang
    And user memilih produk yang ingin dibayar
    And user mengklik tombol Checkout
    Then user diarahkan ke halaman Checkout
    And user memilih alamat pengiriman
    And user memilih jumlah produk di halaman Checkout
    And user mengklik tombol Checkout untuk melanjutkan
    And user memilih metode pembayaran
    And user mengklik tombol Pay
    Then user diarahkan ke halaman Pembayaran

  Scenario: Gagal melakukan checkout produk dari cart dengan tidak memilih produk
    When user memilih tab Cart pada navigation bar
    Then user akan diarahkan ke dalam halaman keranjang
    And user mengklik tombol Checkout
    Then user akan mendapatkan error message checkout