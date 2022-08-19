public class _6floodFill {
    public static void f(int[][] image, int x, int y, int oldcolor, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != oldcolor)
            return;
        image[x][y] = newColor;
        f(image, x - 1, y, oldcolor, newColor);
        f(image, x, y - 1, oldcolor, newColor);
        f(image, x + 1, y, oldcolor, newColor);
        f(image, x, y + 1, oldcolor, newColor);
    }

    public static int[][] floodFill(int[][] image, int x, int y, int newColor) {
        // Write your code here
        int oldcolor = image[x][y];
        if (oldcolor != newColor)
            f(image, x, y, oldcolor, newColor);
        return image;
    }
}
