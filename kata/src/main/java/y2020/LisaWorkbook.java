package y2020;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * /challenges/lisa-workbook/problem
 * <p>
 * n chapters
 * arr[i] = no of problem of chapter n
 * k - problems per page
 * - each chpter start on new page
 * page indexing starts at 1
 * <p>
 * count its number of special problems -  a problem to be special if its
 * <p>
 * index (within a chapter) is the same as the page number where it's located.
 */
public class LisaWorkbook {


    static int workbook(int chapters, int problemsPerPage, int[] problemsPerChapter) {
        int pageNo = 1;
        int specialProblems = 0;

        for (int chapter = 0; chapter < problemsPerChapter.length; chapter++) {

            int chapterPages = problemsPerChapter[chapter] / problemsPerPage + (problemsPerChapter[chapter] % problemsPerPage > 0 ? 1 : 0);

            for (int chapterPage = 1; chapterPage < chapterPages + 1; chapterPage++) {

                int startProb = 1 + ((chapterPage - 1) * problemsPerPage);

                int endProb =  startProb + problemsPerPage -1 ;
                if (chapterPage == chapterPages && problemsPerChapter[chapter] % problemsPerPage > 0){
                       int mod  = problemsPerChapter[chapter] % problemsPerPage;
                       endProb = startProb - 1  + mod ;
                }

                if (startProb <= pageNo && pageNo <= endProb) {
                    specialProblems++;
                }

                pageNo++;
            }

        }

        return specialProblems;
    }

    @Test
    public void t1() {
        assertEquals(4, workbook(5, 3, new int[]{4, 2, 6, 1, 10}));
    }
}
