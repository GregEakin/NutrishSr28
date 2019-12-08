/*
 * Copyright (c) 2019. Greg Eakin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.eakin.server;

import java.util.Arrays;

public class Database {
    public static void main(String[] args) {
        String dir = System.getProperty("user.dir");
        System.out.println(dir);

        args = Arrays.copyOf(args, args.length + 4);
        args[args.length - 4] = "--trace";
        args[args.length - 3] = "false";
        args[args.length - 2] = "--props";

        // C:\Users\gregp\IdeaProjects\NutrishSr28\out\production\sr28\dev\eakin\server
        args[args.length - 1] = ".\\out\\production\\sr28\\dev\\eakin\\server\\server.properties";

        for (String item : args) {
            System.out.print(item);
            System.out.print(" ");
        }
        System.out.println();

        org.hsqldb.server.Server.main(args);
    }
}
