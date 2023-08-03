import argparse
import json
if __name__ == '__main__':
    parser = argparse.ArgumentParser()
    parser.add_argument('--table-name=', type=str, default = 'a')
    parser.add_argument('--table-cols=', type=str, default = 'a')
    parser.add_argument('--label', type=str, default = 'a')
    parser.add_argument('--factor-count', type=int, default=32)
    args = parser.parse_args()
    a=[]
    a.append(args.label)
    a.append(args.factor_count)
    a.append(args.table_cols)
    a.append(args.table_name)
    print(json.dumps(a))