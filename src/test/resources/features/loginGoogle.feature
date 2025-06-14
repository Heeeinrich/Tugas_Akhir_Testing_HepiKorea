Feature: User Google Login
  Pengujian fitur login oleh user dan admin menggunakan google account

  Background:
    Given user membuka platform HepiKorea
    When user mengklik tombol login di halaman homepage
    Then user diarahkan ke dalam halaman login

  Scenario Outline: Login menggunakan Google Account
    Given user berada di halaman login
    When user mengklik tombol Login With Google
    And user memilih akun Google "<Google Account>"
    And user mengklik tombol login di dalam halaman login
    Then user mendapatkan respon "<Expected_result>"

    Examples:
      | Google Account            | Expected_result                                                      |
      | heinrichraditya@gmail.com | user diarahkan ke dalam halaman homepage                         |
      | failed@gmail.com          | user tidak pergi dari halaman login karena gmail tidak ditemukan |
