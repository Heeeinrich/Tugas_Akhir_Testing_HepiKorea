Feature: Customer Logout
  Pengujian fitur logout oleh customer

  Background:
    Given user membuka platform HepiKorea
    And user telah melakukan login sebagai customers

  Scenario: Berhasil Logout
    When user memilih tab profile picture pada navigation bar melalui homepage
    And user memilih tab logout pada dropdown profile
    Then user akan kembali ke homepage dan menampilkan tombol login pada navigation bar
