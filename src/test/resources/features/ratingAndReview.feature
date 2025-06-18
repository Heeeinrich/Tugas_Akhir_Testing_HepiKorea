Feature: Rating and Review
  Pengujian fitur Rating dan Review oleh user
  yang digunakan untuk memberikan review terhadap produk yang telah dipesan

  Background:
    Given user telah melakukan login sebagai customers
    And user berada di homepage

  Scenario: Menilai produk menggunakan Rating dan Review melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    And user mengklik tombol Review
    And user memilih rating produk
    And user menulis review produk
    And user mengklik tombol Submit
    Then rating dan review akan ditampilkan dalam produk detail produk tersebut

  Scenario: Gagal menilai produk tanpa memberikan Rating melalui Riwayat Pemesanan
    Given user berada di homepage
    When user memilih tab Profile Picture pada navigation bar
    And user memilih tab History pada dropdown Profile
    Then user akan diarahkan ke dalam halaman Riwayat Pemesanan
    And user memilih section Finish
    And user mengklik tombol Review
    And user mengklik tombol Submit
    Then user akan mendapatkan pesan error review