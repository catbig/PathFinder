/** *****************************************************************************
 * Copyright 2014 uniVocity Software Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ***************************************************************************** */
package com.myconfident.pathfinder.parser;

import com.myconfident.pathfinder.object.Matrix;
import java.io.*;
import java.util.*;

import com.univocity.parsers.common.*;
import com.univocity.parsers.common.processor.*;
import com.univocity.parsers.csv.*;

public class Parser {
    private Matrix matrix = new Matrix();
    private int[][] map = new int[1000][1000];
    private int line = 0;
    private int x, y;

    public Matrix parse(File file) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.getFormat().setLineSeparator("\n");

        //turning off features enabled by default
        settings.getFormat().setLineSeparator("\n");
        settings.setIgnoreLeadingWhitespaces(false);
        settings.setIgnoreTrailingWhitespaces(false);
        settings.setSkipEmptyLines(false);
        settings.setColumnReorderingEnabled(false);
        settings.getFormat().setDelimiter(' ');
        settings.setMaxColumns(1100);

        settings.setProcessor(new AbstractRowProcessor() {
            @Override
            public void rowProcessed(String[] row, ParsingContext context) {
                parseRows(context.currentLine(), row);
            }
        });

        CsvParser parser = new CsvParser(settings);
        parser.parse(file);
        matrix.setMap(map);
        return matrix;
    }

    private void parseRows(long currentLine, String[] row) {
        line = (int) currentLine;
        line--;
        if (line > 0) {
            for (int i = 0; i < row.length; i++) {
                map[line - 1][i] = Integer.parseInt(row[i]);
            }
        } else {
            matrix.setX(Integer.parseInt(row[0]));
            matrix.setY(Integer.parseInt(row[1]));
        }
    }

}
