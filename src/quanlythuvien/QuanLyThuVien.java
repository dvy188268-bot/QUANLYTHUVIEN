package quanlythuvien;
import java.util.Scanner;
public class QuanLyThuVien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int n = 0;
        String[] ma = new String[100];
        String[] ten = new String[100];
        double[] gia = new double[100];
        int[] sl = new int[100];
 
        int chon;
        // Bài 3: menu lặp đến khi chọn Thoát
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Nhập n cuốn sách");
            System.out.println("2. Tính tổng số lượng và tổng giá trị");
            System.out.println("3. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
 
            if (chon == 1) {
                // Bài 1: nhập n sách bằng vòng lặp
                System.out.print("Nhập n: ");
                n = sc.nextInt();
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    System.out.println("Sách thứ " + (i + 1));
                    System.out.print("Mã sách: ");
                    ma[i] = sc.nextLine();
                    System.out.print("Tên sách: ");
                    ten[i] = sc.nextLine();
                    System.out.print("Đơn giá: ");
                    gia[i] = sc.nextDouble();
                    System.out.print("Số lượng: ");
                    sl[i] = sc.nextInt();
                    sc.nextLine();
                }
            } else if (chon == 2) {
                // Bài 2: tổng số lượng và tổng giá trị
                int tongSL = 0;
                double tongGiaTri = 0;
                for (int i = 0; i < n; i++) {
                    tongSL += sl[i];
                    tongGiaTri += gia[i] * sl[i];
                }
                System.out.println("Tổng số lượng: " + tongSL);
                System.out.println("Tổng giá trị: " + tongGiaTri);
            } else if (chon == 3) {
                // Bài 4: tìm sách theo mã
                System.out.print("Nhập mã cần tìm: ");
                String timMa = sc.nextLine();
                boolean timThay = false;
                for (int i = 0; i < n; i++) {
                    if (ma[i].equals(timMa)) {
                        System.out.println("Tìm thấy: " + ma[i] + " - " + ten[i]
                                + " - Giá: " + gia[i] + " - SL: " + sl[i]);
                        timThay = true;
                    }
                }
                if (!timThay) {
                    System.out.println("Không tìm thấy sách!");
                }
            } else if (chon != 0) {
                System.out.println("Chọn sai, nhập lại!");
            }
        } while (chon != 0);
 
        System.out.println("Thoát chương trình.");
    }
}