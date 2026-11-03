package quanlythuvien;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyThuVien {
    static Scanner sc = new Scanner(System.in);
    // Bài 3: mỗi phần tử là 1 cuốn sách dạng "ma;ten;gia;sl"
    static ArrayList<String> danhSachSach = new ArrayList<>();

    // Tìm vị trí sách theo mã, không thấy trả về -1
    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            if (p[0].equals(ma)) {
                return i;
            }
        }
        return -1;
    }

    // ===== Bài 1: mảng số lượng của 5 cuốn sách =====
    static void bai1() {
        int[] soLuong = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Số lượng sách " + (i + 1) + ": ");
            soLuong[i] = sc.nextInt();
        }
        sc.nextLine();

        int tong = 0;
        int max = soLuong[0];
        System.out.println("Số lượng các sách:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Sách " + (i + 1) + ": " + soLuong[i]);
            tong += soLuong[i];
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tổng: " + tong);
        System.out.println("Lớn nhất: " + max);
    }

    // ===== Bài 2: ArrayList<String> lưu mã sách =====
    static void bai2() {
        ArrayList<String> dsMa = new ArrayList<>();
        int c;
        do {
            System.out.println("\n--- Quản lý mã sách ---");
            System.out.println("1. Thêm  2. Hiển thị  3. Tìm  4. Xóa  0. Quay lại");
            System.out.print("Chọn: ");
            c = sc.nextInt();
            sc.nextLine();

            if (c == 1) {
                System.out.print("Nhập mã sách: ");
                dsMa.add(sc.nextLine());
            } else if (c == 2) {
                if (dsMa.size() == 0) {
                    System.out.println("Danh sách trống!");
                }
                for (int i = 0; i < dsMa.size(); i++) {
                    System.out.println((i + 1) + ". " + dsMa.get(i));
                }
            } else if (c == 3) {
                System.out.print("Nhập mã cần tìm: ");
                String m = sc.nextLine();
                if (dsMa.contains(m)) {
                    System.out.println("Tìm thấy ở vị trí " + (dsMa.indexOf(m) + 1));
                } else {
                    System.out.println("Không tìm thấy!");
                }
            } else if (c == 4) {
                System.out.print("Nhập mã cần xóa: ");
                String m = sc.nextLine();
                if (dsMa.remove(m)) {
                    System.out.println("Đã xóa!");
                } else {
                    System.out.println("Không tìm thấy!");
                }
            }
        } while (c != 0);
    }

    // ===== Bài 3: các chức năng với danhSachSach =====
    static void themSach() {
        System.out.print("Mã sách: ");
        String ma = sc.nextLine();
        if (timViTri(ma) >= 0) {
            System.out.println("Mã sách đã tồn tại!");
            return;
        }
        System.out.print("Tên sách: ");
        String ten = sc.nextLine();
        System.out.print("Đơn giá: ");
        double gia = sc.nextDouble();
        System.out.print("Số lượng: ");
        int sl = sc.nextInt();
        sc.nextLine();
        danhSachSach.add(ma + ";" + ten + ";" + gia + ";" + sl);
        System.out.println("Đã thêm sách!");
    }

    static void hienThiSach() {
        if (danhSachSach.size() == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            System.out.println((i + 1) + ". " + p[0] + " - " + p[1]
                    + " - Giá: " + p[2] + " - SL: " + p[3]);
        }
    }

    static void timSach() {
        System.out.print("Nhập mã cần tìm: ");
        int vt = timViTri(sc.nextLine());
        if (vt >= 0) {
            String[] p = danhSachSach.get(vt).split(";");
            System.out.println("Tìm thấy: " + p[0] + " - " + p[1]
                    + " - Giá: " + p[2] + " - SL: " + p[3]);
        } else {
            System.out.println("Không tìm thấy sách!");
        }
    }

    static void xoaSach() {
        System.out.print("Nhập mã cần xóa: ");
        int vt = timViTri(sc.nextLine());
        if (vt >= 0) {
            danhSachSach.remove(vt);
            System.out.println("Đã xóa sách!");
        } else {
            System.out.println("Không tìm thấy sách!");
        }
    }

    static void suaSach() {
        System.out.print("Nhập mã sách cần sửa: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt < 0) {
            System.out.println("Không tìm thấy sách!");
            return;
        }
        System.out.print("Tên mới: ");
        String ten = sc.nextLine();
        System.out.print("Đơn giá mới: ");
        double gia = sc.nextDouble();
        System.out.print("Số lượng mới: ");
        int sl = sc.nextInt();
        sc.nextLine();
        danhSachSach.set(vt, ma + ";" + ten + ";" + gia + ";" + sl);
        System.out.println("Đã sửa sách!");
    }

    static int tinhTongSL() {
        int tong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            tong += Integer.parseInt(p[3]);
        }
        return tong;
    }

    static double tinhTongGiaTri() {
        double tong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            tong += Double.parseDouble(p[2]) * Integer.parseInt(p[3]);
        }
        return tong;
    }

    public static void main(String[] args) {
        int chon;
        // Bài 4: menu hoàn chỉnh
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.println("9. Chạy Bài 1 (mảng)");
            System.out.println("10. Chạy Bài 2 (ArrayList mã sách)");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();

            if (chon == 1) {
                themSach();
            } else if (chon == 2) {
                hienThiSach();
            } else if (chon == 3) {
                timSach();
            } else if (chon == 4) {
                xoaSach();
            } else if (chon == 5) {
                suaSach();
            } else if (chon == 6) {
                System.out.println("Tổng số lượng: " + tinhTongSL());
            } else if (chon == 7) {
                System.out.println("Tổng giá trị: " + tinhTongGiaTri());
            } else if (chon == 9) {
                bai1();
            } else if (chon == 10) {
                bai2();
            } else if (chon != 8) {
                System.out.println("Chọn sai, nhập lại!");
            }
        } while (chon != 8);

        System.out.println("Thoát chương trình.");
    }
}