class Solution {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return new ArrayList<>();

        int L = beginWord.length();

        // allWords = wordList + beginWord
        Set<String> allWords = new HashSet<>(wordList);
        allWords.add(beginWord);

        // pattern map: a*d -> [and, add]
        Map<String, List<String>> patternMap = new HashMap<>();

        for (String word : allWords) {
            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // distance map: shortest distance from beginWord
        Map<String, Integer> distance = new HashMap<>();
        distance.put(beginWord, 0);

        // parent lists for path reconstruction
        Map<String, List<String>> parents = new HashMap<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int foundEndDist = Integer.MAX_VALUE;

        // BFS
        while (!queue.isEmpty()) {
            String word = queue.remove();
            int dist = distance.get(word);

            if (dist + 1 > foundEndDist) continue;

            for (int i = 0; i < L; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);

                List<String> neighbors = patternMap.getOrDefault(pattern, new ArrayList<>());

                for (String neigh : neighbors) {
                    if (neigh.equals(word)) continue;

                    if (!distance.containsKey(neigh)) {
                        distance.put(neigh, dist + 1);
                        queue.add(neigh);
                        parents.put(neigh, new ArrayList<>(Arrays.asList(word)));
                    } else if (distance.get(neigh) == dist + 1) {
                        parents.get(neigh).add(word);
                    }

                    if (neigh.equals(endWord)) {
                        foundEndDist = Math.min(foundEndDist, dist + 1);
                    }
                }
            }
        }

        if (!distance.containsKey(endWord)) return new ArrayList<>();

        // Backtracking to build all sequences
        List<List<String>> results = new ArrayList<>();
        List<String> path = new ArrayList<>();

        backtrack(endWord, beginWord, parents, path, results);

        return results;
    }

    private void backtrack(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> results
    ) {
        path.add(word);

        if (word.equals(beginWord)) {
            List<String> copy = new ArrayList<>(path);
            Collections.reverse(copy);
            results.add(copy);
        } else {
            List<String> preds = parents.getOrDefault(word, new ArrayList<>());
            for (String p : preds) {
                backtrack(p, beginWord, parents, path, results);
            }
        }

        path.remove(path.size() - 1);
    }
}
