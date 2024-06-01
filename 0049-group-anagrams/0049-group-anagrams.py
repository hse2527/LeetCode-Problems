class Solution(object):
    def groupAnagrams(self, strs):
        def hashWord(word):
            ret = 0
            sortedWord = sorted(word)
            for i in range(len(sortedWord)):
                ret += ord(sortedWord[i]) * (26**i)
            return ret
        
        wordDict = {}
        for word in strs:
            ind = hashWord(word)
            value = wordDict.get(ind, [])
            value.append(word)
            wordDict[ind] = value
        wordSet = []
        for ind, key in enumerate(wordDict):
            wordSet.append(wordDict[key])
        return wordSet

